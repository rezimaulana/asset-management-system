import { ExamCollectionUpdateDataResDto } from "./exam-collection.update.data.res.dto";

export class ExamCollectionUpdateResDto{
    private _data! : ExamCollectionUpdateDataResDto
	private _message! : string

    public get data(): ExamCollectionUpdateDataResDto {
        return this._data;
    }

    public set data(data: ExamCollectionUpdateDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }
    
}