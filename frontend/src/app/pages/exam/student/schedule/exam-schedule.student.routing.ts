import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { ExamScheduleListComponentStudent } from "./list/exam-schedule-list.student.component";

const routes : Routes = [
    {
        path : "schedule",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : ExamScheduleListComponentStudent
            }
        ]
    },
    {
        path : 'schedule/:id/material',
        loadChildren : () => import('../material/exam-material.student.module').then(mod => mod.ExamMaterialModuleStudent)
    },
    {
        path : 'schedule/:id/collection',
        loadChildren : () => import('../collection/exam-collection.student.module').then(mod => mod.ExamCollectionModuleStudent)
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

export class ExamScheduleRoutingStudent{}