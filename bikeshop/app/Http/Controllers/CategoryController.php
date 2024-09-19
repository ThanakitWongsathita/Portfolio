<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\Product;
use Config;
use App\Models\Category;
use Validator;

class CategoryController extends Controller
{
    var $rp = 2;

    public function __construct()
    {
        //$this->rp = Config::get('app.result_per_page');
    }

    public function index()
    {
        $category = Category::paginate($this->rp);
        return view('category/index', compact('category'));
    }

    public function search(Request $request)
    {
        $query = $request->q;
        if($query)
        {
            $category = Category::where('name', 'like', '%'.$query.'%')
            ->orWhere('id', 'like', '%'.$query.'%')
            ->paginate($this->rp);
        }
        
        else
        {
            $category = Category::paginate($this->rp);
        }
        
        return view('category/index', compact('category'));
    }
    
    public function edit($id = null)
    {
        $category = Category::pluck('name')->prepend('Select list', '');
        
        if($id)
        {
            //edit view
            $category = Category::find($id);

            return view('category/edit')
            ->with('category', $category);
        }
        
        else
        {
            return view('category/add')
            ->with('categories', $category);
        }
        
    }

    public function update(Request $request) 
    {
        $rules = array(
            'Category name' => 'required',
        );

        $messages = array(
            'required' => 'Please input information in :attribute ', 
            'numeric' => 'Please input information in
            :attribute as number',
        );
            
        $id = $request->id;

        $temp = array(
            'Category name' => $request->name,
        );

        $validator = Validator::make($temp, $rules, $messages);

        if ($validator->fails()) 
        {
            return redirect('category/edit/'.$id)
            ->withErrors($validator)
            ->withInput();
        }
        
        $category = Category::find($id);
        $category->name = $request->name;

        $category->save();

        return redirect('category')
        ->with('ok', true)
        ->with('msg', 'Save Successfully');
    }

    public function insert(Request $request) 
    {
        $rules = array(
            'Category name' => 'required',
        );

        $messages = array(
            'required' => 'Please input information in :attribute ', 
            'numeric' => 'Please input information in
            :attribute as number',
        );
            
        $id = $request->id;

        $temp = array(
            'Category name' => $request->name,
        );

        $validator = Validator::make($temp, $rules, $messages);

        if ($validator->fails()) 
        {
            return redirect('category/edit/'.$id)
            ->withErrors($validator)
            ->withInput();
        }
        
        $category = new Category();
        $category->name = $request->name;

        $category->save();

        return redirect('category')
        ->with('ok', true)
        ->with('msg', 'Save Successfully');
    }

    public function remove($id) 
    {
        Category::find($id)->delete();
        return redirect('category')
        ->with('ok', true)
        ->with('msg', 'Delete successfully');
    }
    
    
}
