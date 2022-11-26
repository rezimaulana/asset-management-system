import { ClassDtlInsertDataResDto } from "./class-dtl.insert.data.res.dto";

export class ClassDtlInsertResDto{
    private _data! : ClassDtlInsertDataResDto
	private _message! : string

    public get data(): ClassDtlInsertDataResDto {
        return this._data;
    }

    public set data(data: ClassDtlInsertDataResDto) {
        this._data = data;
    }

    public get message(): string {
        return this._message;
    }

    public set message(message: string) {
        this._message = message;
    }

}