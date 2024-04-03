import { prisma } from "../db";
import express, { Request, Response, NextFunction } from 'express';
import { assert } from 'superstruct';
import { BookCreationData } from '../validation/book';
import { BookUpdateData } from '../validation/book';
import { Prisma } from "@prisma/client";


export async function get_all(req: Request, res: Response) {
  const assoc: Prisma.BookInclude = {
    author: {
      select: { id: true, firstname: true,lastname: true },
      
    }
  };
  const { title }: { title?: string } = req.query
    const books=await prisma.book.findMany({
      skip: 1,
      take:2,
      where : {
        title : { contains : title || undefined}
      },
      include : assoc,
      orderBy : {
        title : 'asc'
      }
    });   
    res.json({books});  
};

export async function get_one(req: Request, res: Response) {
    const book = await prisma.book.findUnique({
        where: {
          id: Number(req.params.book_id),
        },
      })
    if(book==null) {
        res.status(404).send(' 404 Author not found');
    }
    else {
        res.status(200).json({book});
    }
};

export async function get_all_of_author(req: Request, res: Response) {
  const { title }: { title?: string } = req.query
    const book = await prisma.book.findMany({
        where: {
          authorId: Number(req.params.author_id),
          title : { contains : title || undefined }
        },
        orderBy : {
          title : 'asc'
        }
      })
    if(book==null) {
        res.status(404).send(' 404 Author not found');
    }
    else {
        res.status(200).json({book});
    }
};

export async function create_one_of_author(req: Request, res: Response) {
    assert(req.body, BookCreationData);
    const books= await prisma.book.create({
        data : {
            title : 'Les miserables',
            authorId : Number(req.params.author_id)
        }
    })   
    res.status(201).json({books});
};


export async function update_one(req: Request, res: Response) {
    assert(req.body, BookUpdateData);
    const bookUpdate = await prisma.book.update({
        where: {
          id : Number(req.params.book_id),
        },
        data: {
          title: 'Le grand Remplacement',
        },
      })
    res.status(201).json({bookUpdate}); 
};

export async function delete_one(req: Request, res: Response) {
    const deleteBook = await prisma.book.delete({
        where: {
          id : Number(req.params.book_id),
        },
      })
    res.status(204).json({deleteBook}); 
};