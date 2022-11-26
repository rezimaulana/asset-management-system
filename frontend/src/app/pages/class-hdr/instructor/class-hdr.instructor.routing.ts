import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ClassHdrDetailComponentInstructor } from "./detail/class-hdr-detail.instructor.component";
import { ClassHdrListComponentInstructor } from "./list/class-hdr-list.instructor.component";

const routes : Routes = [
    {
        path : "",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ClassHdrListComponentInstructor
            },
            {
                path: "detail/:id",
                component : ClassHdrDetailComponentInstructor
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

export class ClassHdrRoutingInstructor{}