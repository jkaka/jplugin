package com.kaka.jplugin.autocode;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "drive")
public class Car extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println("Car drive...888");
    }
}