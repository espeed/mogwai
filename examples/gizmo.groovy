import mogwai.interfaces.GizmoType as GizmoType;
import mogwai.factories.JythonFactory as JythonFactory;
import org.codehaus.groovy.runtime.MethodClosure as MethodClosure;

// Specify the Jython module and its associated Java Interface
jython_module = "/home/james/projects/mogwai/mogwai/steps/jython/Gizmo.py";
java_interface = "mogwai.interfaces.GizmoType";


// Create a Java Object for the Jython module
JythonFactory jf = JythonFactory.getInstance();
GizmoType gizmo = jf.getJythonObject(java_interface,jython_module);


// Create a MethodClosure for each of the object's methods
square = new MethodClosure(gizmo, "square");
getName = new MethodClosure(gizmo, "getName");
jyVertex = new MethodClosure(gizmo, "jyVertex");


// Create a Gremlin closure for each MethodClosure
squareClosure = { final Object... params -> 
  n = params[0]  
  _().transform{ square.call(n) }  
}

getNameClosure = { 
  _().transform{ getName.call() } 
}

jyVertexClosure = { 
  _().transform{ jyVertex.call(it) } 
}


// Define a Gremlin step for each closure
Gremlin.defineStep("square", [Vertex,Pipe], squareClosure) 
Gremlin.defineStep("getName", [Vertex,Pipe], getNameClosure) 
Gremlin.defineStep("jyVertex", [Vertex,Pipe], jyVertexClosure) 


// Test it out
g = TinkerGraphFactory.createTinkerGraph();

println "\nGremlin steps..."

println g.v(1).getName() >> 1
println g.v(1).square(5) >> 1
println g.v(1).jyVertex().name >> 1


