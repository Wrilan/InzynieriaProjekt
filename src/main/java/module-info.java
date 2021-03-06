module Inzynieria
{
    requires java.desktop;
    requires java.naming;
    requires java.sql;
    requires java.xml;

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    requires itext;
    requires core.renderer.R8;
    requires jdk.xml.dom;

    exports app;
    exports app.controllers;
    exports app.dao;
    exports app.entity;
    exports app.utilities;
}