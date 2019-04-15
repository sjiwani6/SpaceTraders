package edu.gatech.cs2340.milestones.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.model.Model;
import edu.gatech.cs2340.milestones.spacetraders.model.UniverseInteractor;

public class UniverseViewModel extends AndroidViewModel {

    private UniverseInteractor interactor;

    /**
     * this os a constructor for the class.
     * @param application passes in a application.
     */
    public UniverseViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getUniverseInteractor();
    }

    /**
     * this is the setter/add method for the universe.
     * @param universe takes in a universe as a parameter.
     */
    public void addUniverse(Universe universe) {
        interactor.addUniverse(universe);
    }

    /**
     * this is the getter for the universe method.
     * @return returns the universe.
     */
    public Universe getUniverse() {
        return interactor.getUniverse();
    }
}
