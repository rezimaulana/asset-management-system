import { NgModule } from "@angular/core";
import { ForumRoutingInstructor } from "./forum.instructor.routing";
import { ForumDetailComponentInstructor } from "./detail/forum-detail.instructor.component";
import { ForumListComponentInstructor } from "./list/forum-list.instructor.component";

@NgModule({
    declarations : [
        ForumListComponentInstructor, ForumDetailComponentInstructor
    ],
    imports : [
        ForumRoutingInstructor
    ],
    exports : [
        ForumListComponentInstructor, ForumDetailComponentInstructor
    ]
})

export class ForumModuleInstructor{}