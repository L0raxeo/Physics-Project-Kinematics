package com.l0raxeo.appk.components;

import com.l0raxeo.appk.dataStructure.Transform;
import com.l0raxeo.appk.window.Camera;

import java.awt.*;

public class RectRenderer extends Component
{

    private Color color;
    private final boolean isSolid;

    public RectRenderer(Color color, boolean isSolid)
    {
        this.color = color;
        this.isSolid = isSolid;
    }

    @Override
    public void render(Graphics g)
    {
        Transform t = gameObject.transform;
        g.setColor(this.color);
        if (isSolid)
            g.fillRect((int) (t.getScreenPosition().x + Camera.xOffset()), (int) (t.getScreenPosition().y + Camera.yOffset()), (int) t.scale.x, (int) t.scale.y);
        else
            g.drawRect((int) (t.getScreenPosition().x + Camera.xOffset()), (int) (t.getScreenPosition().y + Camera.yOffset()), (int) t.scale.x, (int) t.scale.y);
    }

    public void setColor(Color color)
    {
        this.color = color;
    }

}
