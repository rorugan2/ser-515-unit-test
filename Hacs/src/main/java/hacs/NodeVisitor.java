package hacs;

/**
 * Title: HACS Description: Copyright: Copyright (c) 2002 Company: asu
 *
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

abstract class NodeVisitor {

    public NodeVisitor() {
    }

    public NodeVisitor(Object visitee) {
    }

    abstract void visitFacade(Facade facade);

    abstract void visitCourse(Course course);

    abstract void visitAssignment(Assignment assignment);

}
