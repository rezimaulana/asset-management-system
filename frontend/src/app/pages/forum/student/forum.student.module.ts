import { NgModule } from "@angular/core";
import { ForumListComponentStudent } from "./list/forum-list.student.component";
import { ForumDetailComponentStudent } from "./detail/forum-detail.student.component";
import { ForumRoutingStudent } from "./forum.student.routing";
import { ForumInsertComponentStudent } from "./insert/forum-insert.student.component";

@NgModule({
    declarations : [
        ForumListComponentStudent, ForumInsertComponentStudent, ForumDetailComponentStudent
    ],
    imports : [
        ForumRoutingStudent
    ],
    exports : [
        ForumListComponentStudent, ForumInsertComponentStudent, ForumDetailComponentStudent
    ]
})

export class ForumModuleStudent{}