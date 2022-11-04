package hacs;

import java.util.Iterator;

/**
 * Title:        HACS
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      msu
 * @author Zhang ji Zhu Wei
 * @version 1.0
 */

public class SolutionIterator implements Iterator {
    SolutionList solutionList;
    int currentSolutionNumber = -1;

    /**
     * Constructor for SolutionIterator
     */
    public SolutionIterator() {
    }

    public SolutionIterator(SolutionList solutionList) {
        this.solutionList = solutionList;
        moveToHead();
    }

    public void moveToHead() {
        currentSolutionNumber = -1;
    }

    public boolean hasNext() {
        return !(currentSolutionNumber >= solutionList.size() - 1);
    }

    public Object next() {
        if (hasNext()) {
            currentSolutionNumber++;
            return solutionList.get(currentSolutionNumber);
        } else {
            return null;
        }
    }


    public Object next(String userName) {
        Solution theSolution = (Solution) next();
        while (theSolution != null) {
            if (userName.compareTo(theSolution.theAuthor) == 0) {
                return theSolution;
            }
            theSolution = (Solution) next();
        }
        return null;
    }

    public void remove() {
        solutionList.remove(currentSolutionNumber);
    }
}
