/*
 * Copyright (C) 2016 Satomichi Nishihara
 *
 * This file is distributed under the terms of the
 * GNU General Public License. See the file `LICENSE'
 * in the root directory of the present distribution,
 * or http://www.gnu.org/copyleft/gpl.txt .
 */

package burai.app.project.viewer.result.movie;

import burai.app.project.QEFXProjectController;
import burai.app.project.viewer.result.QEFXResultButtonWrapper;
import burai.project.Project;
import burai.project.property.ProjectGeometryList;
import burai.project.property.ProjectProperty;

public class QEFXMdMovieButton extends QEFXMovieButton {

    private static final String BUTTON_TITLE = "MD";
    private static final String BUTTON_SUBTITLE = ".movie";
    private static final String BUTTON_FONT_COLOR = "-fx-text-fill: snow";
    private static final String BUTTON_BACKGROUND = "-fx-background-color: derive(limegreen, -5.0%)";

    public static QEFXResultButtonWrapper<QEFXMdMovieButton> getWrapper(QEFXProjectController projectController, Project project) {

        ProjectProperty projectProperty = project == null ? null : project.getProperty();
        if (projectProperty == null) {
            return null;
        }

        ProjectGeometryList projectGeometryList = projectProperty.getMdList();
        if (projectGeometryList == null || projectGeometryList.numGeometries() < 2) {
            return null;
        }

        return () -> new QEFXMdMovieButton(projectController, projectGeometryList);
    }

    private QEFXMdMovieButton(QEFXProjectController projectController, ProjectGeometryList projectGeometryList) {
        super(projectController, projectGeometryList, BUTTON_TITLE, BUTTON_SUBTITLE);

        this.setIconStyle(BUTTON_BACKGROUND);
        this.setLabelStyle(BUTTON_FONT_COLOR);
    }
}
