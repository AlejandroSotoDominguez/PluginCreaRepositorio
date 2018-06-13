/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.myorg.creareepositorio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

@ActionID(
        category = "File",
        id = "org.myorg.creareepositorio.CreaRepositorio"
)
@ActionRegistration(
        iconBase = "org/myorg/creareepositorio/icon16.png",
        displayName = "#CTL_CreaRepositorio"
)
@ActionReference(path = "Toolbars/File", position = 0)
@Messages("CTL_CreaRepositorio=Crear Repositorio")
public final class CreaRepositorio implements ActionListener {
    
    //Código que se ejecutará al hacer clic en el icono del plugin.
    @Override
    public void actionPerformed(ActionEvent e) {
        //Introducimos por pantalla el nombre del repositorio que queremos crear
        String repositorio = JOptionPane.showInputDialog("Nombre del repositorio");
        try {
            //Establecemos la conexión con github usando las credenciales del archivo .github
            GitHub github = GitHub.connect();
            //Creamos el repositorio
            GHCreateRepositoryBuilder builder;
            builder=github.createRepository(repositorio);
            builder.create();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
