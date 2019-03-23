package edu.gatech.cs2340.milestones.spacetraders.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.milestones.spacetraders.entity.Universe;
import edu.gatech.cs2340.milestones.spacetraders.model.Model;
import edu.gatech.cs2340.milestones.spacetraders.model.UniverseInteractor;

public class UniverseViewModel extends AndroidViewModel {

    private UniverseInteractor interactor;

    public UniverseViewModel(@NonNull Application application) {
        super(application);
        interactor = Model.getInstance().getUniverseInteractor();
    }
    public void addUniverse(Universe universe) {
        interactor.addUniverse(universe);
    }

    public Universe getUniverse() {
        return interactor.getUniverse();
    }
}
