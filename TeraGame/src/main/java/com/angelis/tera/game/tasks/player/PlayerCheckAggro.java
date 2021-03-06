package com.angelis.tera.game.tasks.player;

import java.util.List;

import com.angelis.tera.game.models.creature.TeraCreature;
import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.services.BattleService;
import com.angelis.tera.game.tasks.AbstractTask;
import com.angelis.tera.game.tasks.TaskTypeEnum;

public class PlayerCheckAggro extends AbstractTask<Player> {

    public PlayerCheckAggro(final Player linkedObject, final TaskTypeEnum taskType) {
        super(linkedObject, TaskTypeEnum.PLAYER_CHECK_AGGRO);
    }

    @Override
    public void execute() {
        final List<TeraCreature> teraCreatures = BattleService.getInstance().getCreaturesAggroListContainingVisibleTeraObject(this.linkedObject);
        if (teraCreatures.isEmpty()) {
            this.cancel();
            this.linkedObject.getController().onEndAttack();
        }
    }
}
