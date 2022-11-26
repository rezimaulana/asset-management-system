import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { LearningScheduleListComponentInstructor } from "./list/learning-schedule-list.instructor.component";
import { LearningScheduleInsertComponentInstructor } from "./insert/learning-schedule-insert.instructor.component";

const routes : Routes = [
    {
        path : "schedule",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : LearningScheduleListComponentInstructor
            },
            {
                path: "new",
                component : LearningScheduleInsertComponentInstructor
            }
        ]
    },
    {
        path : 'schedule/:id/attendance',
        loadChildren : () => import('../attendance/learning-attendance.instructor.module').then(mod => mod.LearningAttendanceModuleInstructor)
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

export class LearningScheduleRoutingInstructor{}