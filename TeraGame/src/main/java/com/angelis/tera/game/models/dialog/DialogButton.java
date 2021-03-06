package com.angelis.tera.game.models.dialog;

import com.angelis.tera.game.models.dialog.enums.DialogIconEnum;
import com.angelis.tera.game.models.dialog.enums.DialogStringEnum;

public final class DialogButton {
    
    public final Dialog dialog;
    public final DialogIconEnum dialogIcon;
    public final String text;
    public final AbstractDialogAction dialogAction;
    
    public DialogButton(final Dialog dialog, final DialogIconEnum dialogIcon, final String text, final AbstractDialogAction dialogAction) {
        this.dialog = dialog;
        this.dialogIcon = dialogIcon;
        this.text = text;
        this.dialogAction = dialogAction;
    }
    
    public DialogButton(final Dialog dialog, final DialogIconEnum dialogIcon, final DialogStringEnum dialogString, final AbstractDialogAction dialogAction) {
        this(dialog, dialogIcon, "@npc:"+dialogString.value, dialogAction);
    }
    
    public void action() {
        this.dialogAction.action();
    }

    public DialogIconEnum getDialogIcon() {
        return dialogIcon;
    }

    public String getText() {
        return text;
    }
}
