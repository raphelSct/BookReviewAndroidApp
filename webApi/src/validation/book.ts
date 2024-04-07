import { title } from 'process';
import { object, string, size, integer, number } from 'superstruct';

export const BookCreationData = object({
  title: size(string(), 1, 50),
  
});

export const BookUpdateData = object({
    title: size(string(), 1, 50),
    
  });