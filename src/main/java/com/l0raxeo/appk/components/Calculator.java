package com.l0raxeo.appk.components;

import org.joml.Vector2f;
import org.joml.Vector4d;

import java.util.Scanner;

public class Calculator extends Component
{

    private Scanner scanner;
    private Graph graph;

    public boolean calculating;

    public Calculator()
    {
        this.scanner = new Scanner(System.in);
    }

    //-------------------------------------------------------------------

    public void k0() {
        this.graph = gameObject.getComponent(Graph.class);
        System.out.println("select which variable you are solving for:");
        System.out.println("[d] (displacement)");
        System.out.println("[vi] (initial velocity)");
        System.out.println("[vf] (final velocity)");
        System.out.println("[t] (time)");

        Vector4d vars = new Vector4d();

        switch (scanner.nextLine())
        {
            case "d" -> vars = k0d();
            case "vi" -> vars = k0vi();
            case "vf" -> vars = k0vf();
            case "t" -> vars = k0t();
        }

        double vi, vf, t, d;
        vi = vars.x;
        vf = vars.y;
        t = vars.z;
        d = vars.w;

        // graphing stuff
        graph.setResolution((float) t, (float) Math.max(vi, vf));
        Vector2f ps = graph.graphToScreen(0, (float) vi);
        Vector2f pe = graph.graphToScreen((float) t, (float) vf);
        graph.setPlot(ps.x, ps.y, pe.x, pe.y);
        Vector2f p2s = graph.graphToScreen(0, (float) ((vi + vf) / 2));
        Vector2f p2e = graph.graphToScreen((float) t, (float) ((vi + vf) / 2));
        graph.setPlot2(p2s.x, p2s.y, p2e.x, p2e.y);
    }

    private Vector4d k0d()
    {
        double vi, vf, t, d;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter time");
        t = scanner.nextDouble();

        d = ((vi + vf) / 2) * t;
        System.out.println("Displacement = " + d);

        return new Vector4d(vi, vf, t, d);
    }

    private Vector4d k0vi()
    {
        double d, t, vf, vi;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter time (cannot be 0)");
        t = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();

        vi = (((2 * d) / t) - vf);
        System.out.println("initial velocity = " + vi);

        return new Vector4d(vi, vf, t, d);
    }

    private Vector4d k0vf()
    {
        double d, t, vi, vf;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter time (cannot be 0)");
        t = scanner.nextDouble();
        System.out.println("enter displacements");
        d = scanner.nextDouble();

        vf = (((2 * d) / t) - vi);
        System.out.println("final velocity = " + vf);

        return new Vector4d(vi, vf, t, d);
    }

    private Vector4d k0t()
    {
        double d, vi, vf, t;
        System.out.println("enter initial velocity (vi + vf != 0)");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity (vi + vf != 0)");
        vf = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();

        t = ((2 * d) / (vi + vf));
        System.out.println("time = " + t);

        return new Vector4d(vi, vf, t, d);
    }

    //-------------------------------------------------------------------

    public void k1()
    {
        System.out.println("select which variable you are solving for:");
        System.out.println("[vf] (final velocity)");
        System.out.println("[vi] (initial velocity)");
        System.out.println("[a] (acceleration)");
        System.out.println("[t] (time)");

        switch (scanner.nextLine())
        {
            case "vf" -> k1vf();
            case "vi" -> k1vi();
            case "a" -> k1a();
            case "t" -> k1t();
        }
    }

    private void k1vf()
    {
        double vi, a, t;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();
        System.out.println("enter time");
        t = scanner.nextDouble();

        System.out.println("final velocity = " + (vi + (a * t)));
    }

    private void k1vi()
    {
        double vf, a, t;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();
        System.out.println("enter time");
        t = scanner.nextDouble();

        System.out.println("initial velocity = " + (vf - (a * t)));
    }

    private void k1a()
    {
        double vf, vi, t;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter time (t != 0)");
        t = scanner.nextDouble();

        System.out.println("acceleration = " + ((vf - vi) / t));
    }

    private void k1t()
    {
        double vf, vi, a;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter acceleration (a != 0)");
        a = scanner.nextDouble();

        System.out.println("time = " + ((vf - vi) / a));
    }

    //-------------------------------------------------------------------

    public void k2()
    {
        System.out.println("select which variable you are solving for:");
        System.out.println("[d] (displacement)");
        System.out.println("[vi] (initial velocity)");
        System.out.println("[t] (time)");
        System.out.println("[a] (acceleration)");

        switch (scanner.nextLine())
        {
            case "d" -> k2d();
            case "vi" -> k2vi();
            case "t" -> k2t();
            case "a" -> k2a();
        }
    }

    private void k2d()
    {
        double vi, t, a;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter time");
        t = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();

        System.out.println("displacement = " + (vi * t + ((a * Math.pow(t, 2)) / 2)));
    }

    private void k2vi()
    {
        double d, t, a;
        System.out.println("enter displacement");
        d = scanner.nextDouble();
        System.out.println("enter time (t != 0)");
        t = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();

        System.out.println("initial velocity = " + ((d / t) - ((a * Math.pow(t, 2)) / 2)));
    }

    private void k2t()
    {
        double vi, d, a;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();

        double sqrt = Math.sqrt((2 * d * a) + Math.pow(vi, 2));
        System.out.println("time = " + ((-vi + sqrt) / a) + " & " + ((-vi - sqrt) / a));
    }

    private void k2a()
    {
        double d, vi, t;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();
        System.out.println("enter time (t != 0)");
        t = scanner.nextDouble();

        System.out.println("acceleration = " + (((2 * d) - (2 * vi * t)) / Math.pow(t, 2)));
    }

    //-------------------------------------------------------------------

    public void k3()
    {
        System.out.println("select which variable you are solving for:");
        System.out.println("[vf] (final velocity)");
        System.out.println("[vi] (initial velocity)");
        System.out.println("[a] (acceleration)");
        System.out.println("[d] (displacement)");

        switch (scanner.nextLine())
        {
            case "vf" -> k3vf();
            case "vi" -> k3vi();
            case "a" -> k3a();
            case "d" -> k3d();
        }
    }

    private void k3vf()
    {
        double vi, a, d;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();

        System.out.println("final velocity = +-" + Math.sqrt(Math.pow(vi, 2) + (2 * a * d)));
    }

    private void k3vi()
    {
        double vf, a, d;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();

        System.out.println("initial velocity = +-" + Math.sqrt(Math.pow(vf, 2) - (2 * a * d)));
    }

    private void k3a()
    {
        double vf, vi, d;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter displacement (d != 0)");
        d = scanner.nextDouble();

        System.out.println("acceleration = " + ((Math.pow(vf, 2) - Math.pow(vi, 2)) / (2 * d)));
    }

    private void k3d()
    {
        double vi, vf, a;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter acceleration (a != 0)");
        a = scanner.nextDouble();

        System.out.println("displacement = " + ((Math.pow(vf, 2) - Math.pow(vi, 2)) / (2 * a)));
    }

    //-------------------------------------------------------------------

    public void k4()
    {
        System.out.println("select which variable you are solving for:");
        System.out.println("[d] (displacement)");
        System.out.println("[vf] (final velocity)");
        System.out.println("[t] (time)");
        System.out.println("[a] (acceleration)");

        switch (scanner.nextLine())
        {
            case "vf" -> k1vf();
            case "vi" -> k1vi();
            case "a" -> k1a();
            case "t" -> k1t();
        }
    }

    private void k4d()
    {
        double vf, t, a;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter time");
        t = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();

        System.out.println("displacement = " + ((vf * t) - ((a * Math.pow(t, 2)) / 2)));
    }

    private void k4vf()
    {
        double d, a, t;
        System.out.println("enter displacement");
        d = scanner.nextDouble();
        System.out.println("enter acceleration");
        a = scanner.nextDouble();
        System.out.println("enter time (t != 0)");
        t = scanner.nextDouble();

        System.out.println("final velocity = " + (((2 * d) + (a * Math.pow(t, 2))) / (2 * t)));
    }

    private void k4t()
    {
        double vf, d, a;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();
        System.out.println("enter acceleration (a != 0)");
        a = scanner.nextDouble();

        double sqrt = Math.sqrt(Math.pow(vf, 2) - (2 * a * d));
        System.out.println("time = " + ((-vf + sqrt) / a) + " & " + ((vf + sqrt) / a));
    }

    private void k4a()
    {
        double vf, d, t;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter final displacement");
        d = scanner.nextDouble();
        System.out.println("enter time (t != 0)");
        t = scanner.nextDouble();

        System.out.println("acceleration = " + (-(((2 * d) - (2 * vf * t)) / Math.pow(t, 2))));
    }

}
