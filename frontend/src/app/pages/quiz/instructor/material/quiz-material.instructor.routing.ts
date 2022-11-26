import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { QuizMaterialListComponentInstructor } from "./list/quiz-material-list.instructor.component";
import { QuizMaterialInsertComponentInstructor } from "./insert/quiz-material-insert.instructor.component";
import { QuizMaterialDetailComponentInstructor } from "./detail/quiz-material-detail.instructor.component";

const routes : Routes = [
    {
        path : "material",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : QuizMaterialListComponentInstructor
            },
            {
                path: "new",
                component : QuizMaterialInsertComponentInstructor
            },
            {
                path: "detail/:id",
                component : QuizMaterialDetailComponentInstructor
            }
        ]
    },
    {
        path : 'material/:id',
        loadChildren : () => import('../schedule/quiz-schedule.instructor.module').then(mod => mod.QuizScheduleModuleInstructor)
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

export class QuizMaterialRoutingInstructor{}