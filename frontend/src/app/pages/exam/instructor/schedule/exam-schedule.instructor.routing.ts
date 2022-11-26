import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ExamScheduleListComponentInstructor } from "./list/exam-schedule-list.instructor.component";
import { ExamScheduleInsertComponentInstructor } from "./insert/exam-schedule-insert.instructor.component";

const routes : Routes = [
    {
        path : "schedule",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ExamScheduleListComponentInstructor
            },
            {
                path: "new",
                component : ExamScheduleInsertComponentInstructor
            }
        ]
    },
    {
        path : 'schedule/:id/attendance',
        loadChildren : () => import('../attendance/exam-attendance.instructor.module').then(mod => mod.ExamAttendanceModuleInstructor)
    },
    {
        path : 'schedule/:id/collection',
        loadChildren : () => import('../collection/exam-collection.instructor.module').then(mod => mod.ExamCollectionModuleInstructor)
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

export class ExamScheduleRoutingInstructor{}