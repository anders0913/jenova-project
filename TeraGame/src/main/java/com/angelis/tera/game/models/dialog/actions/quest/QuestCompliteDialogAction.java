package com.angelis.tera.game.models.dialog.actions.quest;

import com.angelis.tera.game.models.dialog.AbstractDialogAction;
import com.angelis.tera.game.models.dialog.Dialog;
import com.angelis.tera.game.models.player.Player;
import com.angelis.tera.game.models.quest.Quest;
import com.angelis.tera.game.services.QuestService;

public class QuestCompliteDialogAction extends AbstractDialogAction {

    private final Quest quest;

    public QuestCompliteDialogAction(final Player player, final Dialog dialog, final Quest quest) {
        super(player, dialog);
        this.quest = quest;
    }

    @Override
    public void action() {
        QuestService.getInstance().onPlayerCompliteQuest(this.player, this.quest);
    }
}
