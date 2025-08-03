﻿using LibraryAPI.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.Identity.Client;

namespace LibraryAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class BooksController : ControllerBase
    {
        private readonly BookContext _dbContext;

        public BooksController(BookContext dbContext)
        {
            _dbContext = dbContext;
        }

        //GET: library/Books
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Book>>> GetBooks()
        {
            if(_dbContext.Books == null)
            {
                return NotFound();
            }
            return await _dbContext.Books.ToListAsync();
        }

        //GET: library/Books/3
        [HttpGet("{id}")]

        public async Task<ActionResult<Book>> GetBook(int id)
        {
            if(_dbContext.Books == null )
            {
                return NotFound();
            }

            var book = await _dbContext.Books.FindAsync(id);

            if(book == null)
            {
                return NotFound();
            }

            return book;
         }

        //POST: library/Books
        [HttpPost]
        public async Task<ActionResult<Book>> PostBook(Book book)
        {

            _dbContext.Books.Add(book);
            await _dbContext.SaveChangesAsync();
            return CreatedAtAction(nameof(GetBook), new {id = book.Id }, book);
         
        }

        //PUT: library/Books/2
        [HttpPut("{id}")]
        public async Task<IActionResult> PutBook(int id, Book book)
        {
            if(id != book.Id)
            {
                Console.Write(book.ToString());
                return BadRequest();
            }

            _dbContext.Entry(book).State = EntityState.Modified;

            try
            {
                await _dbContext.SaveChangesAsync();
            }
            catch(DbUpdateConcurrencyException)
            {
                if (!BookExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        //Delete: library/Books/3
        [HttpDelete("{id}")]

        public async Task<IActionResult> deleteBook(int id)
        {
            if(_dbContext.Books == null)
            {
                return NotFound();
            }

            var book = await _dbContext.Books.FindAsync(id);
            if(book == null)
            {
                return NotFound();
            }

            _dbContext.Books.Remove(book);
            await _dbContext.SaveChangesAsync();

            return NoContent();
        }
        private bool BookExists(long id)
        {
            return (_dbContext.Books?.Any(e => e.Id == id)).GetValueOrDefault();
        }

    }
}
