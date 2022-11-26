import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { QuizCollectionInsertComponentStudent } from "./insert/quiz-collection-insert.student.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentStudent,
        children : [
            {
                path: "new",
                component : QuizCollectionInsertComponentStudent
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

export class QuizCollectionRoutingStudent{}