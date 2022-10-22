package com.l0raxeo.appk.components;

import java.util.Scanner;

public class Calculator extends Component {

    private final Scanner scanner;

    public Calculator()
    {
        this.scanner = new Scanner(System.in);
    }

    //-------------------------------------------------------------------

    public void k0() {
        System.out.println("select which variable you are solving for:");
        System.out.println("[d] (displacement)");
        System.out.println("[vi] (initial velocity)");
        System.out.println("[vf] (final velocity)");
        System.out.println("[t] (time)");

        switch (scanner.nextLine())
        {
            case "d" -> k0d();
            case "vi" -> k0vi();
            case "vf" -> k0vf();
            case "t" -> k0t();
        }
    }

    private void k0d()
    {
        double vi, vf, t;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter time");
        t = scanner.nextDouble();

        System.out.println("Displacement = " + ((vi + vf) / 2) * t);
    }

    private void k0vi()
    {
        double d, t, vf;
        System.out.println("enter final velocity");
        vf = scanner.nextDouble();
        System.out.println("enter time (cannot be 0)");
        t = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();

        System.out.println("initial velocity = " + (((2 * d) / t) - vf));
    }

    private void k0vf()
    {
        double d, t, vi;
        System.out.println("enter initial velocity");
        vi = scanner.nextDouble();
        System.out.println("enter time (cannot be 0)");
        t = scanner.nextDouble();
        System.out.println("enter displacements");
        d = scanner.nextDouble();

        System.out.println("final velocity = " + (((2 * d) / t) - vi));
    }

    private void k0t()
    {
        double d, vi, vf;
        System.out.println("enter initial velocity (vi + vf != 0)");
        vi = scanner.nextDouble();
        System.out.println("enter final velocity (vi + vf != 0)");
        vf = scanner.nextDouble();
        System.out.println("enter displacement");
        d = scanner.nextDouble();

        System.out.println("time = " + ((2 * d) / (vi + vf)));
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

    }

    private void k1vi()
    {

    }

    private void k1a()
    {

    }

    private void k1t()
    {

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
            case "vf" -> k2d();
            case "vi" -> k2vi();
            case "a" -> k2t();
            case "t" -> k2a();
        }
    }

    private void k2d()
    {

    }

    private void k2vi()
    {

    }

    private void k2t()
    {

    }

    private void k2a()
    {

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

    }

    private void k3vi()
    {

    }

    private void k3a()
    {

    }

    private void k3d()
    {

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
            case "d" -> k1vf();
            case "vf" -> k1vi();
            case "t" -> k1a();
            case "a" -> k1t();
        }
    }

    private void k4d()
    {

    }

    private void k4vf()
    {

    }

    private void k4t()
    {

    }

    private void k4a()
    {

    }

}
