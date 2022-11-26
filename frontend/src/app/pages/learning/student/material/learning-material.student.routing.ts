import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { LearningMaterialDetailComponentStudent } from "./detail/learning-material-detail.student.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentStudent,
        children : [
            {
                path: "detail/:id",
                component : LearningMaterialDetailComponentStudent
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

export class LearningMaterialRoutingStudent{}