package com.l0raxeo.appk.scenes;

import com.l0raxeo.appk.components.Calculator;
import com.l0raxeo.appk.components.Component;
import com.l0raxeo.appk.components.Graph;
import com.l0raxeo.appk.dataStructure.AssetPool;
import com.l0raxeo.appk.objects.GameObject;
import com.l0raxeo.appk.prefabs.Prefabs;
import org.joml.Vector2f;

import java.awt.*;
import java.util.Scanner;

public class MainScene extends Scene
{

    private Scanner scanner;
    private int curEquationId = -1;

    private GameObject calcObj;
    private Calculator calculator;

    @Override
    public void init()
    {
        scanner = new Scanner(System.in);
        addGameObjectToScene(calcObj = Prefabs.generate(
                "Calculator",
                new Vector2f(),
                new Vector2f(),
                new Graph(),
                new Calculator()
        ));
    }

    @Override
    public void start()
    {
        calculator = getGameObject("Calculator").getComponent(Calculator.class);

        updateEquationId();
    }

    @Override
    public void loadResources() {
        AssetPool.getFont("assets/fonts/default_font.ttf", 32);
    }

    private void prompt()
    {
        curEquationId = -1;
        System.out.println("enter an equation:");
        System.out.println("[0] d = (0.5 * (vi + vf)) * t");
        System.out.println("[1] vf = vi + a * t");
        System.out.println("[2] d = vi * t + 0.5 * a * t^2");
        System.out.println("[3] vf^2 = xi + vi^2 + 2 * a * d");
        System.out.println("[4] d = xi + vf * t - 0.5 * a * t^2");

        curEquationId = scanner.nextInt();

        if (curEquationId < -1 || curEquationId > 4)
        {
            System.out.println("Invalid option");
            curEquationId = -1;
        }

        updateEquationId();
    }

    @Override
    public void update(double dt) {
        for (GameObject go : getGameObjects())
            go.update(dt);

        getGameObjects().removeIf(GameObject::isDead);

        if (!calculator.calculating)
        {
            curEquationId = -1;
            updateEquationId();
        }
    }

    @Override
    public void render(Graphics g) {
        gui(g);

        for (GameObject go : getGameObjects())
        {
            for (Component c : go.getAllComponents())
                c.render(g);
        }
    }

    public void updateEquationId()
    {
        switch (curEquationId)
        {
            case -1 -> prompt();
            case 0 -> calculator.k0();
            case 1 -> calculator.k1();
            case 2 -> calculator.k2();
            case 3 -> calculator.k3();
            case 4 -> calculator.k4();
        }

        if (curEquationId != -1)
            calculator.calculating = true;
    }

}
