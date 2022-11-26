import { ExamCollectionInsertDataResDto } from "./exam-collection.insert.data.res.dto";

export class ExamCollectionInsertResDto{
    private _data! : ExamCollectionInsertDataResDto
	private _message! : string

    public get data(): ExamCollectionInsertDataResDto {
        return this._data;
    }

    public set data(data: ExamCollectionInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}