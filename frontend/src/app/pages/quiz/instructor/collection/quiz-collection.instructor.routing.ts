import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { QuizCollectionListComponentInstructor } from "./list/quiz-collection-list.instructor.component";
import { QuizCollectionUpdateComponentInstructor } from "./update/quiz-collection-update.instructor.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : QuizCollectionListComponentInstructor
            },
            {
                path: "edit/:id",
                component : QuizCollectionUpdateComponentInstructor
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

export class QuizCollectionRoutingInstructor{}