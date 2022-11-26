import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { QuizScheduleListComponentStudent } from "./list/quiz-schedule-list.student.component";

const routes : Routes = [
    {
        path : "schedule",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : QuizScheduleListComponentStudent
            }
        ]
    },
    {
        path : 'schedule/:id/material',
        loadChildren : () => import('../material/quiz-material.student.module').then(mod => mod.QuizMaterialModuleStudent)
    },
    {
        path : 'schedule/:id/collection',
        loadChildren : () => import('../collection/quiz-collection.student.module').then(mod => mod.QuizCollectionModuleStudent)
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

export class QuizScheduleRoutingStudent{}