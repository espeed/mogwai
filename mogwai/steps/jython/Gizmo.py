from mogwai.interfaces import GizmoType

class Gizmo(GizmoType):

    def getName(self):
        return "Gizmo"

    def square(self, x):
        return x*x

    def jyVertex(self, v):
        return v

