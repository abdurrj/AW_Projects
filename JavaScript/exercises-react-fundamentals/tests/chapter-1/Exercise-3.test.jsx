/* eslint-disable */

const React = require('react');

const {
  findDOMNode
} = require('react-dom');

const {
  createRenderer
} = require('react-addons-test-utils');

describe('Exercise 3-1 - My first component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFirstComponentWithProps
        name={'Eirik'}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="awesome">
        Hi, my name is Eirik!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFirstComponentWithProps
        name={'Lise'}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="awesome">
        Hi, my name is Lise!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 3)', () => {
    let renderer = createRenderer();

    const {
      MyFirstComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFirstComponentWithProps
        name={'Anna'}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="awesome">
        Hi, my name is Anna!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-2 - My second component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MySecondComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySecondComponentWithProps
        customClasses={['blabla']}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="blabla">
        This is some amazing content!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MySecondComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySecondComponentWithProps
        customClasses={['bingbong', 'yaddayadda']}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="bingbong yaddayadda">
        This is some amazing content!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 3)', () => {
    let renderer = createRenderer();

    const {
      MySecondComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySecondComponentWithProps
        customClasses={['heyhoe', 'yoyo', 'dingdong']}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div className="heyhoe yoyo dingdong">
        This is some amazing content!
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-3 - My third component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MyThirdComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyThirdComponentWithProps
        paragraphs={[
          'This is paragraph 1',
          'This is paragraph 2'
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <p>This is paragraph 1</p>
        <p>This is paragraph 2</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MyThirdComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyThirdComponentWithProps
        paragraphs={[
          'This is paragraph 1 - hello',
          'This is paragraph 2 - world'
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <p>This is paragraph 1 - hello</p>
        <p>This is paragraph 2 - world</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 3)', () => {
    let renderer = createRenderer();

    const {
      MyThirdComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyThirdComponentWithProps
        paragraphs={[
          'This is paragraph 1 - goodbye',
          'This is paragraph 2 - planet'
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <p>This is paragraph 1 - goodbye</p>
        <p>This is paragraph 2 - planet</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 4)', () => {
    let renderer = createRenderer();

    const {
      MyThirdComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyThirdComponentWithProps
        paragraphs={[
          'This is paragraph 1 - goodbye',
          'This is paragraph 2 - world',
          'This is paragraph 3 - planet',
          'This is paragraph 4 - express'
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <p>This is paragraph 1 - goodbye</p>
        <p>This is paragraph 2 - world</p>
        <p>This is paragraph 3 - planet</p>
        <p>This is paragraph 4 - express</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-4 - My fourth component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MyFourthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFourthComponentWithProps
        lists={[
          ['List 1 - Item 1', 'List 1 - Item 2'],
          ['List 2 - Item 1', 'List 2 - Item 2']
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <ul>
          <li>List 1 - Item 1</li>
          <li>List 1 - Item 2</li>
        </ul>
        <ul>
          <li>List 2 - Item 1</li>
          <li>List 2 - Item 2</li>
        </ul>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MyFourthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFourthComponentWithProps
        lists={[
          ['List 1 - Item 1', 'List 1 - Item 2']
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <ul>
          <li>List 1 - Item 1</li>
          <li>List 1 - Item 2</li>
        </ul>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 3)', () => {
    let renderer = createRenderer();

    const {
      MyFourthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFourthComponentWithProps
        lists={[
          ['List 1 - Item 1', 'List 1 - Item 2'],
          ['List 2 - Item 1', 'List 2 - Item 2'],
          ['List 3 - Item 1', 'List 3 - Item 2']
        ]}
      />
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <ul>
          <li>List 1 - Item 1</li>
          <li>List 1 - Item 2</li>
        </ul>
        <ul>
          <li>List 2 - Item 1</li>
          <li>List 2 - Item 2</li>
        </ul>
        <ul>
          <li>List 3 - Item 1</li>
          <li>List 3 - Item 2</li>
        </ul>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-5 - My fifth component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MyFifthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFifthComponentWithProps>
        <div>Hello</div>
        <p>world</p>
      </MyFifthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <div>Hello</div>
        <p>world</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MyFifthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyFifthComponentWithProps>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </MyFifthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-6 - My sixth component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MySixthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySixthComponentWithProps showDetails={true}>
        <div>Hello</div>
        <p>world</p>
      </MySixthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <div>Hello</div>
        <p>world</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MySixthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySixthComponentWithProps showDetails={true}>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </MySixthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 3)', () => {
    let renderer = createRenderer();

    const {
      MySixthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySixthComponentWithProps showDetails={false}>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </MySixthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div></div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-7 - My seventh component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MySeventhComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySeventhComponentWithProps title='Much Wow, Such Title'>
        <div>Hello</div>
        <p>world</p>
      </MySeventhComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <h1>Much Wow, Such Title</h1>
        <div>Hello</div>
        <p>world</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MySeventhComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MySeventhComponentWithProps title='Such Title, Much Wow'>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </MySeventhComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <h1>Such Title, Much Wow</h1>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});

describe('Exercise 3-8 - My eigth component with props', () => {
  it('Should have correct output using props as input (case 1)', () => {
    let renderer = createRenderer();

    const {
      MyEigthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyEigthComponentWithProps title='Much Wow, Such Title' showDetails={true}>
        <div>Hello</div>
        <p>world</p>
      </MyEigthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <h1>Much Wow, Such Title</h1>
        <div>Hello</div>
        <p>world</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 2)', () => {
    let renderer = createRenderer();

    const {
      MyEigthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyEigthComponentWithProps title='Such Title, Much Wow' showDetails={true}>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </MyEigthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <h1>Such Title, Much Wow</h1>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });

  it('Should have correct output using props as input (case 3)', () => {
    let renderer = createRenderer();

    const {
      MyEigthComponentWithProps
    } = require(`../../src/${__version__}/Exercise-3.jsx`);

    renderer.render(
      <MyEigthComponentWithProps title='Such Title, Much Wow' showDetails={false}>
        <div>Hello</div>
        <p>world</p>
        <span>sally</span>
      </MyEigthComponentWithProps>
    );

    let actualElement = renderer.getRenderOutput();

    let expectedElement = (
      <div>
        <h1>Such Title, Much Wow</h1>
        <p>No details..</p>
      </div>
    );

    assert.equalJSX(
      actualElement,
      expectedElement
    );
  });
});
