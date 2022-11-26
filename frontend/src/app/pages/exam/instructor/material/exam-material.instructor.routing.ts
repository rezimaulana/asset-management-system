import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ExamMaterialListComponentInstructor } from "./list/exam-material-list.instructor.component";
import { ExamMaterialInsertComponentInstructor } from "./insert/exam-material-insert.instructor.component";
import { ExamMaterialDetailComponentInstructor } from "./detail/exam-material-detail.instructor.component";

const routes : Routes = [
    {
        path : "material",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ExamMaterialListComponentInstructor
            },
            {
                path: "new",
                component : ExamMaterialInsertComponentInstructor
            },
            {
                path: "detail/:id",
                component : ExamMaterialDetailComponentInstructor
            }
        ]
    },
    {
        path : 'material/:id',
        loadChildren : () => import('../schedule/exam-schedule.instructor.module').then(mod => mod.ExamScheduleModuleInstructor)
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

export class ExamMaterialRoutingInstructor{}