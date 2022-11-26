import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { LearningScheduleListComponentStudent } from "./list/learning-schedule-list.student.component";

const routes : Routes = [
    {
        path : "schedule",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : LearningScheduleListComponentStudent
            }
        ]
    },
    {
        path : 'schedule/:id/material',
        loadChildren : () => import('../material/learning-material.student.module').then(mod => mod.LearningMaterialModuleStudent)
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

export class LearningScheduleRoutingStudent{}