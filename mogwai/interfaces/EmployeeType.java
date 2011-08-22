package mogwai.interfaces;
import groovy.lang.Closure ;
import java.util.Collection;
import com.tinkerpop.blueprints.pgm.Vertex;


public interface EmployeeType {
    
    public String getEmployeeFirst();
    public String getEmployeeLast();
    public String getEmployeeId();
    public int square(int x);
    public Object square2(Object x);
    public Closure myClosure();
    public Collection getTree(Collection vertices);

    public Vertex jyVertex(Vertex v);

}
