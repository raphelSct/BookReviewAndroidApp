import { PrismaClient } from '@prisma/client';
import { Hash } from 'crypto';
import { title } from 'process';
const bcrypt = require('bcryptjs');
const prisma = new PrismaClient();


async function hashPassord(hashedPassword:string){
  hashedPassword = await bcrypt.hash('password', 10);
}



let hashedPassword2: string = "";
bcrypt.hash('motdepasse', 10, function(err:Error, hash:string) {
  hashedPassword2= hash; 
});

const authors = [
    {
      firstname: 'J. R. R.',
      lastname: 'Tolkien'
      
    },
    {
      firstname: 'H. P.',
      lastname: 'Lovecraft',
      books: {
        create: [
          {title: 'Premier livre'},
          {title: 'Deuxième livre'},
          
        ]
      }

    }
  ];
  const books = [
    {
      title: 'Les misérables',
      authorId : 1,
    },
    {
      title: 'La disparition',
      authorId : 2,
    }
  ];

  const tags = [
    {
      name: 'Short',
      
    },
    {
      name: 'Fiction',
      
    }
  ];
  
  

async function main() {
  for (const author of authors) {
    await prisma.author.create({
      data: author,
    });
  }  
  for (const book of books) {
    await prisma.book.create({
      data: {
        title: book.title,
        authorId: book.authorId,
        tags: {
          connectOrCreate: [
            { where: { name: 'Short' }, create: { name: 'Short' } },
            { where: { name: 'Fiction' }, create: { name: 'Fiction' } }
          ]
        }
      }
    });
  } 
  const users = [
    {
      email: 'Eliott@gmail.com',
      password: await bcrypt.hash('password',10),
      username : 'Eliottlebot',
      comments : {
        create: [
          {
            content:'Pas mal celui là',
            created_at:new Date(),
            updated_at: new Date(),
            bookId : 1
          },
          {
            content:'Pas fou',
            created_at:new Date(),
            updated_at: new Date(),
            bookId : 2
          }

        ]
      },
      ratings : {
        create: [
          {
            value : 4,
            bookId : 1
          },
          {
            value : 1,
            bookId : 2
          }
        ]
      }
    },
    {
      email: 'Raphael@gmail.com',
      password:await bcrypt.hash('motdepasse',10),
      username : 'Raphoulefou',
      comments : {
        create: [
          {
            content:'Truc de malade là',
            created_at:new Date(),
            updated_at: new Date(),
            bookId : 3
          },
          {
            content:'Vraiment pas obligatoire',
            created_at:new Date(),
            updated_at: new Date(),
            bookId : 4
          }

        ]
      },
      ratings : {
        create: [
          {
            value : 5,
            bookId : 2
          },
          {
            value : 0,
            bookId : 4
          }
        ]
      }
    },
  ]
  for (const user of users) {
    await prisma.user.create({
      data: user,
    });
}  
    
}



main()
  .then(async () => {
    await prisma.$disconnect();
  })
  .catch(async (e) => {
    console.error(e);
    await prisma.$disconnect();
    process.exit(1);
  });
