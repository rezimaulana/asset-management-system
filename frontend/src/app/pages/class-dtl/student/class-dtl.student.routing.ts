import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ClassDtlListComponentStudent } from "./list/class-dtl-list.student.component";
import { ClassDtlDetailComponentStudent } from "./detail/class-dtl-detail.student.component";
import { ContentComponentStudent } from "../../../components/content/student/content.student.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : ClassDtlListComponentStudent
            },
            {
                path: "detail/:id",
                component : ClassDtlDetailComponentStudent
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

export class ClassDtlRoutingStudent{}