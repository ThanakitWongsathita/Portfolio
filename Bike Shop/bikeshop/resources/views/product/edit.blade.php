@extends('layouts.master') 
@section('title') BikeShop | Edit product information @stop
@section('content')
    <h1>Edit product</h1>
    <ul class="breadcrumb">
        <li><a href="{{ URL::to('product') }}">Home</a></li>
        <li class="active">Edit product </li>
    </ul>
    {!! Form::model($product, array('method' => 'post', 'enctype' => 'multipart/form-data', 
    'action' => 'App\Http\Controllers\ProductController@update')) !!}
    <input type="hidden" name="id" value="{{ $product->id }}">
    
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
                <strong>Product details </strong>
            </div>

        </div>
        
        <div class="panel-body">
            <table>
                <tr>
                    <td>
                        {{ Form::label('code', 'Product id') }}
                    </td>
                    <td>
                        {{ Form::text('code', $product->code, ['class' => 'form-control']) }}
                    </td>
                </tr>
        
                <tr>
                    <td>
                        {{ Form::label('name', 'Product name') }}
                    </td>
                    <td>
                        {{ Form::text('name', $product->name, ['class' => 'form-control']) }}
                    </td>
                </tr>
        
                <tr>
                    <td>
                        {{ Form::label('category_id', 'Product category') }}
                    </td>
                    <td>
                        {{ Form::select('category_id', $categories, Request::old('category_id'), ['class' => 'form-control']) }}
                    </td>
                </tr>
        
                <tr>
                    <td>
                        {{ Form::label('stock_qty', 'Product left') }}
                    </td>
                    <td>
                        {{ Form::text('stock_qty', $product->stock_qty, ['class' => 'form-control']) }}
                    </td>
                </tr>
        
                <tr>
                    <td>
                        {{ Form::label('price', 'Product price') }}
                    </td>
                    <td>
                        {{ Form::text('price', $product->price, ['class' => 'form-control']) }}
                    </td>
                </tr>
        
                <tr>
                    <td>
                        {{ Form::label('image_url', 'Product image') }}
                    </td>
                    <td>
                        {{ Form::file('image') }}
                    </td>
                </tr>

                @if($product->image_url)
                    <tr>
                        <td><strong> Product picture </strong></td>
                        <td><img src="{{ URL::to($product->image_url) }}" width="100px"></td>
                    </tr>
                @endif
        
            </table>
        
        </div>

        <div class="panel-footer">
            <button type="reset" class="btn btn-danger"> Cancle </button>
            <button type="submit" class="btn btn-primary"><i class="fa fa-save"> Save </i></button>
        </div>
    </div>
    
    {!! Form::close() !!}
@endsection