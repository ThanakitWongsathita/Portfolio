@extends('layouts.master') 
@section('title') BikeShop | Edit category information @stop
@section('content')
    <h1>Edit category</h1>
    <ul class="breadcrumb">
        <li><a href="{{ URL::to('category') }}">Home</a></li>
        <li class="active">Edit category </li>
    </ul>
    {!! Form::model($category, array('method' => 'post', 'enctype' => 'multipart/form-data', 
    'action' => 'App\Http\Controllers\CategoryController@update')) !!}
    <input type="hidden" name="id" value="{{ $category->id }}">
    
    @if($errors->any())
    <div class="alert alert-danger">
        @foreach ($errors->all() as $error)
            <div>{{ $error }}</div>
        @endforeach
    </div>
    @endif
    
    <div class="panel panel-default">
        <div class="panel-heading">



            <div class="panel-title">
                <strong> Category details </strong>
            </div>

        </div>
        
        <div class="panel-body">
            <table>
                <tr>
                    <td>
                        {{ Form::label('name', 'Category name') }}
                    </td>
                    <td>
                        {{ Form::text('name', $category->name, ['class' => 'form-control']) }}
                    </td>
                </tr>
        
            </table>
        
        </div>

        <div class="panel-footer">
            <button type="reset" class="btn btn-danger"> Cancle </button>
            <button type="submit" class="btn btn-primary"> <i class="fa fa-save"> Save </i> </button>
        </div>
    </div>
    
    {!! Form::close() !!}
@endsection