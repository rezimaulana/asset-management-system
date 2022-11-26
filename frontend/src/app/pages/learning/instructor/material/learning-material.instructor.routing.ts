import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { LearningMaterialListComponentInstructor } from "./list/learning-material-list.instructor.component";
import { LearningMaterialInsertComponentInstructor } from "./insert/learning-material-insert.instructor.component";
import { LearningMaterialDetailComponentInstructor } from "./detail/learning-material-detail.instructor.component";

const routes : Routes = [
    {
        path : "material",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : LearningMaterialListComponentInstructor
            },
            {
                path: "new",
                component : LearningMaterialInsertComponentInstructor
            },
            {
                path: "detail/:id",
                component : LearningMaterialDetailComponentInstructor
            }
        ]
    },
    {
        path : 'material/:id',
        loadChildren : () => import('../schedule/learning-schedule.instructor.module').then(mod => mod.LearningScheduleModuleInstructor)
    }
];

@NgModule({
    imports : [
        RouterModule.forChild(routes)
    ],
    exports : [
        RouterModule
    ]
})

export class LearningMaterialRoutingInstructor{}