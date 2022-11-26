import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ForumListComponentInstructor } from "./list/forum-list.instructor.component";
import { ForumDetailComponentInstructor } from "./detail/forum-detail.instructor.component";

const routes : Routes = [
    {
        path : "class-hdr/:id",
        component : ContentComponentInstructor,
        children : [
            {
                path: "",
                component : ForumListComponentInstructor
            },
            {
                path: "detail/:id",
                component : ForumDetailComponentInstructor
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

export class ForumRoutingInstructor{}