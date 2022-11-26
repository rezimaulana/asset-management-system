import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { ExamMaterialDetailComponentStudent } from "./detail/exam-material-detail.student.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentStudent,
        children : [
            {
                path: "detail/:id",
                component : ExamMaterialDetailComponentStudent
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

export class ExamMaterialRoutingStudent{}