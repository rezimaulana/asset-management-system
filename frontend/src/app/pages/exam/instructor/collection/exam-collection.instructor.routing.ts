import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ExamCollectionListComponentInstructor } from "./list/exam-collection-list.instructor.component";
import { ExamCollectionUpdateComponentInstructor } from "./update/exam-collection-update.instructor.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ExamCollectionListComponentInstructor
            },
            {
                path: "edit/:id",
                component : ExamCollectionUpdateComponentInstructor
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

export class ExamCollectionRoutingInstructor{}