package com.l0raxeo.appk.components;

import com.l0raxeo.appk.dataStructure.AssetPool;
import com.l0raxeo.appk.ui.GuiText;
import com.l0raxeo.appk.window.Window;
import org.joml.Vector2f;
import org.joml.Vector2i;
import org.joml.Vector4f;

import java.awt.*;

public class Graph extends Component
{

    private final Vector2f resolution = new Vector2f(10, 10);
    private final int GRAPH_SIZE = (int) (getWorldY(32) - 32);
    private final Vector4f plot = new Vector4f();
    private final Vector4f plot2 = new Vector4f();

    @Override
    public void update(double dt) {}

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.RED);
        g.drawLine(32, (int) getWorldY(32), Window.getWidth() - 32, (int) getWorldY(32));
        g.drawLine(32, 32, 32, (int) getWorldY(32));
        g.drawLine((int) plot.x, (int) plot.y, (int) plot.z, (int) plot.w);
        g.setColor(Color.CYAN);
        g.drawLine((int) plot2.x, (int) plot2.y, (int) plot2.z, (int) plot2.w);

        GuiText.drawString(g, "v", new Vector2i(16, 16), true, Color.WHITE, AssetPool.getFont("assets/fonts/default_font.ttf", 32));
        GuiText.drawString(g, "t", new Vector2i(Window.getWidth() - 16, Window.getHeight() - 16), true, Color.WHITE, AssetPool.getFont("assets/fonts/default_font.ttf", 32));
    }

    public Vector2f graphToScreen(float gx, float gy)
    {
        float sx, sy;
        sx = (gx / resolution.x) * GRAPH_SIZE + 32;
        sy = (gy / resolution.y) * GRAPH_SIZE + 32;

        return new Vector2f(sx, Window.getHeight() - sy);
    }

    public Vector2f graphToScreen(Vector2f graphCoordinate)
    {
        return graphToScreen(graphCoordinate.x, graphCoordinate.y);
    }

    private float getWorldY(float y)
    {
        return Window.getHeight() - y;
    }

    private Vector2f screenToWorld(float x, float y)
    {
        return new Vector2f(x, Window.getHeight() - y);
    }

    private Vector2f screenToWorld(Vector2f pos)
    {
        return screenToWorld(pos.x, pos.y);
    }

    public void setResolution(float x, float y)
    {
        this.resolution.x = x;
        this.resolution.y = y;
    }

    public void setPlot(float x, float y, float z, float w)
    {
        this.plot.x = x;
        this.plot.y = y;
        this.plot.z = z;
        this.plot.w = w;
    }

    public void setPlot2(float x, float y, float z, float w)
    {
        this.plot2.x = x;
        this.plot2.y = y;
        this.plot2.z = z;
        this.plot2.w = w;
    }

}
