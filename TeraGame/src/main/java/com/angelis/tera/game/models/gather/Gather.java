package com.angelis.tera.game.models.gather;

import com.angelis.tera.common.utils.Rnd;
import com.angelis.tera.game.controllers.GatherController;
import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.models.template.GatherTemplate;
import com.angelis.tera.game.models.template.HasTemplate;
import com.angelis.tera.game.models.visible.VisibleTeraObject;

public class Gather extends VisibleTeraObject implements HasTemplate<GatherTemplate> {

    private final GatherTemplate template = new GatherTemplate();
    private int remainingGather;
    private Player gatherer;
    
    public Gather(final Integer id) {
        super(id, new GatherController());
        this.getController().setOwner(this);
    }

    @Override
    public GatherTemplate getTemplate() {
        return this.template;
    }

    public int getRemainingGather() {
        return remainingGather;
    }

    public void setRemainingGather(final int remainingGather) {
        this.remainingGather = remainingGather;
    }

    public Player getGatherer() {
        return this.gatherer;
    }
    
    public void setGatherer(final Player gatherer) {
        this.gatherer = gatherer;
    }
    
    @Override
    public GatherController getController() {
        return (GatherController) this.controller;
    }

    public void initGather() {
        final int rand = Rnd.get(0, 100);
        if (rand < 75) {
            this.remainingGather = 1;
        } else if (rand < 90) {
            this.remainingGather = 2;
        } else {
            this.remainingGather = 3;
        }
    }

    public void processGather() {
        this.remainingGather--;
    }
}
