package mogwai.interfaces;
import com.tinkerpop.blueprints.pgm.Vertex;

public interface GizmoType {
    
    public String getName();
    public int square(int x);
    public Vertex jyVertex(Vertex v);

}
