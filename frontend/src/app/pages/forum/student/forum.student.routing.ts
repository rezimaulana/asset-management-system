import { NgModule } from "@angular/core";
import { Routes } from "@angular/router";
import { RouterModule } from "@angular/router";
import { ContentComponentInstructor } from "src/app/components/content/instructor/content.instructor.component";
import { ContentComponentStudent } from "src/app/components/content/student/content.student.component";
import { ForumDetailComponentStudent } from "./detail/forum-detail.student.component";
import { ForumInsertComponentStudent } from "./insert/forum-insert.student.component";
import { ForumListComponentStudent } from "./list/forum-list.student.component";


const routes : Routes = [
    {
        path : "class-dtl/:id",
        component : ContentComponentStudent,
        children : [
            {
                path: "",
                component : ForumListComponentStudent
            },
            {
                path: "new",
                component : ForumInsertComponentStudent
            },
            {
                path: "detail/:id",
                component : ForumDetailComponentStudent
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

export class ForumRoutingStudent{}