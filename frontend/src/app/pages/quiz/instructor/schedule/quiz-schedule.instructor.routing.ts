import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { QuizScheduleListComponentInstructor } from "./list/quiz-schedule-list.instructor.component";
import { QuizScheduleInsertComponentInstructor } from "./insert/quiz-schedule-insert.instructor.component";

const routes : Routes = [
    {
        path : "schedule",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : QuizScheduleListComponentInstructor
            },
            {
                path: "new",
                component : QuizScheduleInsertComponentInstructor
            }
        ]
    },
    {
        path : 'schedule/:id/attendance',
        loadChildren : () => import('../attendance/quiz-attendance.instructor.module').then(mod => mod.QuizAttendanceModuleInstructor)
    },
    {
        path : 'schedule/:id/collection',
        loadChildren : () => import('../collection/quiz-collection.instructor.module').then(mod => mod.QuizCollectionModuleInstructor)
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

export class QuizScheduleRoutingInstructor{}