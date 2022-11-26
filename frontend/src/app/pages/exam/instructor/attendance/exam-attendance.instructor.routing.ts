import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ExamAttendanceListComponentInstructor } from "./list/exam-attendance-list.instructor.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ExamAttendanceListComponentInstructor
            }
        ]
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

export class ExamAttendanceRoutingInstructor{}