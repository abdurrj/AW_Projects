/* eslint-disable */

const React = require('react');

const {
  findDOMNode
} = require('react-dom');

const {
  createRenderer
} = require('react-addons-test-utils');

describe('Exercise 2-1 - My first component with classes', () => {
  it('Should have correct output with css class attribute', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponentWithClasses
    } = require(`../../src/${__version__}/Exercise-2.jsx`);

    renderer.render(
      <MyFirstComponentWithClasses />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="awesome">
        Hello World!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 2-2 - My second component with classes', () => {
  it('Should have correct output with css class attribute', () => {
    let renderer = createRenderer();

    const {
      MySecondComponentWithClasses
    } = require(`../../src/${__version__}/Exercise-2.jsx`);

    renderer.render(
      <MySecondComponentWithClasses />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="awesome-container">
        <p className="awesome-paragraph">Hello World!</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 2-3 - My first component with inline styles', () => {
  it('Should have correct output with inline style attributes', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponentWithInlineStyles
    } = require(`../../src/${__version__}/Exercise-2.jsx`);

    renderer.render(
      <MyFirstComponentWithInlineStyles />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div style={{ backgroundColor: 'red', marginTop: '15px' }}>
        <p style={{ color: 'yellow', marginBottom: '15px' }}>Hello World!</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 2-4 - My second component with inline styles', () => {
  it('Should have correct output with inline style attributes', () => {
    let renderer = createRenderer();

    const {
      MySecondComponentWithInlineStyles
    } = require(`../../src/${__version__}/Exercise-2.jsx`);

    renderer.render(
      <MySecondComponentWithInlineStyles />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div style={{ padding: '20px', border: '1px solid black' }}>
        <p style={{ backgroundColor: 'green', color: 'brown' }}>Hello World!</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 2-5 - My first component with inline styles and classes', () => {
  it('Should have correct output with inline style attributes and css classes', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponentWithInlineStylesAndClasses
    } = require(`../../src/${__version__}/Exercise-2.jsx`);

    renderer.render(
      <MyFirstComponentWithInlineStylesAndClasses />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="awesome-container" style={{ padding: '20px', border: '1px solid black' }}>
        <p className="awesome-paragraph" style={{ backgroundColor: 'green', color: 'brown' }}>Hello World!</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});
